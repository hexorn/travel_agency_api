package com.epam.finaltask.specification;

import com.epam.finaltask.model.*;
import org.springframework.data.jpa.domain.Specification;

public final class UserSearchSpecifications {
    public static Specification<User> hasEmail(String email) {
        return (root, query, criteriaBuilder) ->
                email == null ? null : criteriaBuilder.like(root.get("email"),  "%" + email.toLowerCase() + "%");
    }

    public static Specification<User> hasActiveStatus(Boolean active) {
        return (root, query, criteriaBuilder) ->
                active == null ? null : criteriaBuilder.equal(root.get("active"), active);
    }
}
