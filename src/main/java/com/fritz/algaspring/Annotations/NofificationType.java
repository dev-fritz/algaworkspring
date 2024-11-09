package com.fritz.algaspring.Annotations;

import com.fritz.algaspring.Enums.UrgencyEnum;
import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface NofificationType {
    UrgencyEnum value();
}
