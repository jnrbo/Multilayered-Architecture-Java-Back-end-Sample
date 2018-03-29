package com.juniorbarros.config;

import java.util.UUID;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

/**
 * Created by juniorbarros on 02/09/2017.
 */

// example class, converts string to UUID
public class StringToUUIDConverter implements Converter<String, UUID> {

    @Nullable
    @Override
    public UUID convert(String source) {
        return UUID.nameUUIDFromBytes(source.getBytes());
    }
}
