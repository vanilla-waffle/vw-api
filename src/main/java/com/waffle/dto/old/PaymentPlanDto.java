package com.waffle.dto.old;

import com.waffle.models.constants.types.Payment;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * DTO class of embedded class PaymentPlan for Post.
 */
public enum PaymentPlanDto {
    ;

    private interface Price {
        @NotBlank @NotNull @Positive Long getPrice();
    }

    private interface PaymentEnum {
        @NotBlank @NotNull Payment getPayment();
    }

    /**
     * Request objects of PaymentPlanDto.
     */
    public enum Request {
        ;

        /**
         * Request for create Post.
         */
        @Data
        public static class Create implements Price, PaymentEnum {
            private Long price;
            private Payment payment;
        }
    }

    /**
     * Response objects of PaymentPlanDto.
     */
    public enum Response {
        ;

        /**
         * Response with payment plan information of Post.
         */
        @Data
        public static class All implements Price, PaymentEnum {
            private Long price;
            private Payment payment;
        }
    }
}
