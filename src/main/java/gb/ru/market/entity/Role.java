//package gb.ru.market.entity;
//
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//
//import java.util.Set;
//import java.util.stream.Collectors;
//
//public enum Role {
//    ADMIN(Set.of(Permission.PRODUCTS)),
//    MANAGER(Set.of(Permission.PRODUCTS, Permission.USERS)),
//    SUPERADMIN(Set.of(Permission.PRODUCTS, Permission.USERS, Permission.CREATEUSER));
//
//    private final Set<Permission> permissions;
//
//    Role(Set<Permission> permissions) {
//        this.permissions = permissions;
//    }
//
//    public Set<Permission> getPermissions() {
//        return permissions;
//    }
//
//    public Set<SimpleGrantedAuthority> getAuthorities() {
//        return getPermissions().stream()
//                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
//                .collect(Collectors.toSet());
//    }
//}