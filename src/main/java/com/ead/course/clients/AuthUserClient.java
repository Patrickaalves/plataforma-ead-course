package com.ead.course.clients;

import com.ead.course.dtos.request.ResponsePageDto;
import com.ead.course.dtos.request.UserRecordDto;
import com.ead.course.dtos.response.CourseUserRecordDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;


@Component
public class AuthUserClient {

    Logger logger = LogManager.getLogger(AuthUserClient.class);

    @Value("${ead.api.url.authuser}")
    String baseUrlAuthUser;

    final RestClient restClient;

    public AuthUserClient(RestClient.Builder restclientBuilder) {
        this.restClient = restclientBuilder.build();
    }

    public Page<UserRecordDto> getAllUsersByCourse(UUID courseId, Pageable pageable) {
        String url = UriComponentsBuilder
                .fromUriString(baseUrlAuthUser)
                .pathSegment("users")
                .queryParam("courseId", courseId)
                .queryParam("page", pageable.getPageNumber())
                .queryParam("size", pageable.getPageSize())
                .queryParam("sort", pageable.getSort().stream()
                        .map(order -> order.getProperty() + "," + order.getDirection())
                        .toArray())
                .toUriString();
        logger.debug("metodo getAllUsersByCourse, url gerada: " + url);
        try {
            return restClient.get()
                    .uri(url)
                    .retrieve()
                    .body(new ParameterizedTypeReference<ResponsePageDto<UserRecordDto>>() {});
        } catch (RestClientException e) {
            logger.error("Error request GET restclient with cause: {}", e.getMessage());
            throw new RuntimeException("Error request GET RestClient", e);
        }
    }

    public ResponseEntity<UserRecordDto> getOneUserById(UUID userId) {
        String url = UriComponentsBuilder
                .fromUriString(baseUrlAuthUser)
                .pathSegment("users", userId.toString())
                .toUriString();
        logger.debug("metodo getOneUserById, url gerada: " + url);
        return restClient.get()
                .uri(url)
                .retrieve()
                .onStatus(status -> status.value() == 404, (request, response) -> {
                    logger.error("Error: User not found {}", userId);
                    throw new RuntimeException("Error: User not found");
                    }
                )
                .toEntity(UserRecordDto.class);
    }

    public void postSubscriptionUserInCourse(UUID courseId, UUID userId) {
        String url = UriComponentsBuilder
                .fromUriString(baseUrlAuthUser)
                .pathSegment("users", userId.toString(), "courses", "subscription")
                .toUriString();
        logger.debug("metodo postSubscriptionUserInCourse, url gerada: " + url);
        try {
            var courseUserRecordDto = new CourseUserRecordDto(courseId, userId);
            restClient.post()
                    .uri(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(courseUserRecordDto)
                    .retrieve()
                    .toBodilessEntity();
        } catch (RestClientException e) {
            logger.error("Error request POST with cause: {}", e.getMessage());
            throw new RuntimeException("Error request POST RestClient", e);
        }
    }

    public void deleteCourseUserInAuthUser(UUID courseId) {
        String url = UriComponentsBuilder
                .fromUriString(baseUrlAuthUser)
                .pathSegment("users", "courses" ,courseId.toString())
                .toUriString();
        logger.debug("metodo deleteCourseUserInAuthUser, url gerada: " + url);
        try {
            restClient.delete()
                    .uri(url)
                    .retrieve()
                    .toBodilessEntity();
        } catch (RestClientException e) {
            logger.error("Error request DELETE with cause: {}", e.getMessage());
            throw new RuntimeException("Error request DELETE RestClient", e);
        }
    }
}
