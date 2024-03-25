package de.hitohitonika.notenverwalter.server.data;

public enum Entity {
    CLASS, GRADE, STUDENT, SUBJECT, TEACHER;

    public static Entity fromString(String value) {
        if (value != null) {
            for (Entity entity : Entity.values()) {
                if (value.equalsIgnoreCase(entity.name())) {
                    return entity;
                }
            }
        }
        throw new IllegalArgumentException("No constant with text " + value + " found");
    }
}
