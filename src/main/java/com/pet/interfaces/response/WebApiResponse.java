package com.pet.interfaces.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.pet.interfaces.response.ApiResponseCode.SUCCESS;
import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;
import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Slf4j
@Getter
@Schema(description = "Web Api response")
public class WebApiResponse<T> {
    @Schema(description = "code", example = "VR200", requiredMode = REQUIRED)
    private String code;

    @Schema(description = "message", example = "success", requiredMode = REQUIRED)
    private String message;

    @Schema(description = "data", requiredMode = NOT_REQUIRED)
    @JsonInclude(NON_NULL)
    private T data;

    @Schema(description = "currentTimestamp", example = "1716443872668", requiredMode = REQUIRED)
    @JsonSerialize(using = LocalDateTimeToLongSerializer.class)
    @JsonDeserialize(using = LongToLocalDateTimeDeserializer.class)
    private LocalDateTime currentTimestamp = LocalDateTime.now();

    @Builder
    public WebApiResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = switch (data) {
            case null -> null;
            case Page page -> (T) new PageResponse<>(page);
            default -> data;
        };
    }

    public static <T> WebApiResponse<T> success() {
        String code = SUCCESS.getCode();
        WebApiResponse<T> webApiResponse = WebApiResponse.<T>builder()
                .code(code)
                .message(SUCCESS.getMessage())
                .build();

        log.info("Response : [{}]", code);
        setResultCodeToRequestObj(code);

        return webApiResponse;
    }

    public static <T> WebApiResponse<T> success(T data) {
        String code = SUCCESS.getCode();

        WebApiResponse<T> webApiResponse = WebApiResponse.<T>builder()
                .code(code)
                .message(SUCCESS.getMessage())
                .data(data)
                .build();

        log.info("Response : [{}] {}", code, data);
        setResultCodeToRequestObj(code);

        return webApiResponse;
    }

    public static WebApiResponse error(ApiResponseCode errorCode) {
        WebApiResponse webApiResponse = WebApiResponse.builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .build();

        log.info("Response : [{}, {}]", webApiResponse.getCode(), webApiResponse.getMessage());
        setResultCodeToRequestObj(webApiResponse.getCode());

        return webApiResponse;
    }

    public static <T> WebApiResponse<T> error(ApiResponseCode errorCode, T data) {
        WebApiResponse<T> webApiResponse = WebApiResponse.<T>builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .data(data)
                .build();

        log.info("Response : [{}, {}]", webApiResponse.getCode(), webApiResponse.getMessage());
        setResultCodeToRequestObj(webApiResponse.getCode());

        return webApiResponse;
    }

    public static void setResultCodeToRequestObj(String resultCode) {
        Optional.ofNullable(RequestContextHolder.getRequestAttributes())
                .map(ServletRequestAttributes.class::cast)
                .map(ServletRequestAttributes::getRequest)
                .ifPresent(request -> request.setAttribute("resultCode", resultCode));
    }
}
