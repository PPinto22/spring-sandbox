package com.ppinto.springsandbox.fixtures;

import com.ppinto.springsandbox.model.Address;
import com.ppinto.springsandbox.model.UserRole;
import com.ppinto.springsandbox.patch.ReplaceOp;
import com.ppinto.springsandbox.patch.UserPatch;
import org.jeasy.random.EasyRandom;

import java.util.EnumSet;
import java.util.stream.Collectors;

public class UserPatchBuilders {

    private static final EasyRandom easyRandom = new EasyRandom();

    public static UserPatch.UserPatchBuilder fullUpdate() {
        return UserPatch.builder()
                .name(ReplaceOp.of("New Name"))
                .addresses(ReplaceOp.of(easyRandom.objects(Address.class, 3).collect(Collectors.toList())))
                .roles(ReplaceOp.of(EnumSet.of(UserRole.USER)))
                .settings(UserSettingsPatchBuilders.fullUpdate().build());
    }
}
