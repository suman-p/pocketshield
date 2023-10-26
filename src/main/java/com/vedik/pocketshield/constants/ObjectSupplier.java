package com.vedik.pocketshield.constants;

import com.vedik.pocketshield.dto.ErrorResponseDto;

import java.util.function.Supplier;

public class ObjectSupplier {
    static Supplier<ErrorResponseDto> errorResponseDtoSupplier = () -> {
        return new ErrorResponseDto("", null, "", null);
    };
}
