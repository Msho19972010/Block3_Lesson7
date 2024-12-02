package org.db.students;

import java.util.Objects;
import java.util.stream.Stream;

/*
Represents the option selected by the user
 */

public enum Action {
    EXIT(0, false),
    CREATE(1, true),
    UPDATE(2, true),
    DELETE(3, true),
    STATS_BY_COURSES(4, false),
    SEARCH(6, true),
    ERROR(-1, false);


    private Integer code;
    private boolean requiredAdditionalData;

    Action(Integer code, boolean requiredAdditionalData) {
        this.code = code;
        this.requiredAdditionalData = requiredAdditionalData;
    }

    public Integer getCode() {
        return code;
    }

    public boolean isRequiredAdditionalData() {
        return requiredAdditionalData;
    }

    public static Action fromCode(Integer code) {
        return Stream.of(Action.values())
                .filter(action -> Objects.equals(action.getCode(), code))
                .findFirst()
                .orElseGet(() -> {
                    System.out.println("Unknown action's code " + code);
                    return Action.ERROR;
                });
    }
}
