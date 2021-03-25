package tn.esprit.spring.entity;

public enum ProfileEnum{
    ROLE_ADMIN,
    ROLE_CLIENT,
    ROLE_INTERNAUT,
	ROLE_BANKER;

    public static ProfileEnum getProfile(String profile) {
        switch (profile) {
            case "ROLE_CLIENT":return ROLE_CLIENT;
            case "ROLE_ADMIN":return ROLE_ADMIN;
            case "ROLE_BANKER":return ROLE_BANKER;
            default:return ROLE_INTERNAUT;
        }
    }
}