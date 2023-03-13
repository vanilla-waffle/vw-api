package com.waffle.dto.old;

import com.waffle.models.constants.types.Feature;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.Collection;

/**
 * DTO class for Post entity.
 */
public enum PostDto {
    ;

    private interface Id {
        @Positive Long getId();
    }

    private interface Title {
        @NotBlank @NotNull String getTitle();
    }

    private interface Description {
        @NotBlank @NotNull String getDescription();
    }

    private interface Manufacturer {
        @NotBlank @NotNull String getManufacturer();
    }

    private interface Model {
        @NotBlank @NotNull String getModel();
    }

    private interface ReleaseYear {
        @NotBlank @NotNull @PastOrPresent LocalDate getReleaseYear();
    }

    private interface PaymentPlanEmbeddedAll {
        @NotNull PaymentPlanDto.Response.All getPaymentPlan();
    }

    private interface PaymentPlanEmbeddedCreate {
        @NotNull PaymentPlanDto.Request.Create getPaymentPlan();
    }

    private interface SpecificationEmbeddedAll {
        @NotNull SpecificationDto.Response.All getSpecification();
    }

    private interface SpecificationEmbeddedCreate {
        @NotNull SpecificationDto.Request.Create getSpecification();
    }

    private interface Features {
        Collection<Feature> getFeatures();
    }

    /**
     * Request objects of PostDto.
     */
    public enum Request {
        ;

        /**
         * Request object for create Post.
         */
        @Data
        public static class Create implements Title, Description, Manufacturer, Model, ReleaseYear, PaymentPlanEmbeddedCreate, SpecificationEmbeddedCreate, Features {
            private String title;
            private String description;
            private String manufacturer;
            private String model;
            private LocalDate releaseYear;
            @Valid
            private PaymentPlanDto.Request.Create paymentPlan;
            @Valid
            private SpecificationDto.Request.Create specification;
            private Collection<Feature> features;
        }
    }

    /**
     * Response objects of PostDto.
     */
    public enum Response {
        ;

        /**
         * Response object of PostDto with all information.
         */
        @Data
        public static class All implements Id, Title, Description, Manufacturer, Model, ReleaseYear, PaymentPlanEmbeddedAll, SpecificationEmbeddedAll, Features {
            private Long id;
            private String title;
            private String description;
            private String manufacturer;
            private String model;
            private LocalDate releaseYear;
            private PaymentPlanDto.Response.All paymentPlan;
            private SpecificationDto.Response.All specification;
            private Collection<Feature> features;
        }

        /**
         * Slim response object of PostDto.
         */
        @Data
        public static class Slim implements Id, Title, PaymentPlanEmbeddedAll {
            private Long id;
            private String title;
            private PaymentPlanDto.Response.All paymentPlan;
        }
    }
}
