/*
 * Suppose, we class Plant from the task2, which includes private fields String name, Color color and Type type,
 * and constructor with three String parameters where these fields are initialized. Color and Type are Enum.
 * Color contains White, Red, Blue entries.
 * Type contains Rare and Available entries.
 * And we have classes ColorException and TypeException as derived from Exception.
 * The constructor of Plant throws a corresponding exception whenever an inappropriate parameter is passed.
 * (public Plant(String type, String color, String name) throws ColorException, TypeException)
 * Write a static tryCreatePlant method that takes 3 string parameters - type,
 * color and name and returns an instance of Plant, created based on passed params.
 * (Don't create any classes, write as if you are already inside a class.)
 * The tryCreatePlant method should catch exceptions that can be thrown.
 * If inappropriate type passed as a parameter, a Plant object should be returned anyway, with Ordinary type.
 * If an inappropriate color is passed, set Red color for created instance.
 */

/**
 * @author Bogdan Kurchak
 */
enum Color {
    White, Red, Blue
}

enum Type {
    Rare, Ordinary
}

class ColorException extends Exception {
    public ColorException(String message) {
        super(message);
    }
}

class TypeException extends Exception {
    public TypeException(String message) {
        super(message);
    }
}

class Plant {
    public String name;
    public Color color;
    public Type type;

    public Plant(String type, String color, String name) throws ColorException, TypeException {
        try {
            this.type = Type.valueOf(type);
        } catch (IllegalArgumentException e) {
            throw new TypeException("Illegal type!");
        }

        try {
            this.color = Color.valueOf(color);
        } catch (IllegalArgumentException e) {
            throw new ColorException("Illegal color!");
        }

        this.name = name;
    }

    @Override
    public String toString() {
        return "{type: " + type + ", color: " + color + ", name: " + name +"}";
    }

    public static Plant tryCreatePlant(String type, String color, String name) throws TypeException, ColorException {
        try {
            return new Plant(type, color, name);
        } catch (TypeException typeException) {
            try {
                return new Plant("Ordinary", color, name);
            } catch (ColorException | TypeException e) {}
        } catch (ColorException colorException) {
            try {
                return new Plant(type, "Red", name);
            } catch (ColorException | TypeException e) {}
        }

        return new Plant("Ordinary", "Red", name);
    }
}
