package com.ppinto.springsandbox.fixtures;

import com.ppinto.springsandbox.patch.ReplaceOp;
import com.ppinto.springsandbox.patch.UserSettingsPatch;

public class UserSettingsPatchBuilders {

    public static UserSettingsPatch.UserSettingsPatchBuilder fullUpdate() {
        return UserSettingsPatch.builder()
                .setting1(ReplaceOp.of("New Setting1"))
                .setting2(ReplaceOp.of(2))
                .setting3(ReplaceOp.of(3))
                .setting4(ReplaceOp.of(true));
    }
}
