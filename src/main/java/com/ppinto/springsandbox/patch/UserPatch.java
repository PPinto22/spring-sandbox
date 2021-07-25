package com.ppinto.springsandbox.patch;

import com.ppinto.springsandbox.model.Address;
import com.ppinto.springsandbox.model.User;
import com.ppinto.springsandbox.model.UserRole;
import com.ppinto.springsandbox.model.UserSettings;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPatch implements Patch<User> {

    @NonNull
    @Builder.Default
    private Patch<String> name = NoOp.instance();

    @NonNull
    @Builder.Default
    private Patch<Set<UserRole>> roles = NoOp.instance();

    @NonNull
    @Builder.Default
    private Patch<List<Address>> addresses = NoOp.instance();

    @NonNull
    @Builder.Default
    private Patch<UserSettings> settings = NoOp.instance();

    @Override
    public User apply(User oldUser) {
        throw new UnsupportedOperationException("UserPatch can only be applied via a service");
    }
}
