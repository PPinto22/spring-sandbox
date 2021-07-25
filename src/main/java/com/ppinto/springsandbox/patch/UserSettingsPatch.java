package com.ppinto.springsandbox.patch;

import com.ppinto.springsandbox.model.UserSettings;
import lombok.*;
import org.apache.commons.lang3.ObjectUtils;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSettingsPatch implements Patch<UserSettings> {

    @NonNull
    @Builder.Default
    private Patch<String> setting1 = NoOp.instance();

    @NonNull
    @Builder.Default
    private Patch<Integer> setting2 = NoOp.instance();

    @NonNull
    @Builder.Default
    private Patch<Integer> setting3 = NoOp.instance();

    @NonNull
    @Builder.Default
    private Patch<Boolean> setting4 = NoOp.instance();


    @Override
    public UserSettings apply(UserSettings oldSettings) {
        if (oldSettings == null) oldSettings = new UserSettings();

        return oldSettings.toBuilder()
                .setting1(setting1.apply(oldSettings.getSetting1()))
                .setting2(setting2.apply(oldSettings.getSetting2()))
                .setting3(ObjectUtils.defaultIfNull(setting3.apply(oldSettings.getSetting3()), 0))
                .setting4(setting4.apply(oldSettings.isSetting4()))
                .build();
    }
}
