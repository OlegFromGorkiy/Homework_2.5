package Transport;

public class Car extends Transport {
    BodyType bodyType;

    public Car(String brand, String model, double engineVolume, BodyType bodyType) {
        super(brand, model, engineVolume, DriverLicense.B);
        this.bodyType = bodyType;
    }

    public Car(String brand, String model, double engineVolume, String bodyType) {
        super(brand, model, engineVolume, DriverLicense.B);
        this.bodyType = BodyType.getValue(bodyType) == null ? BodyType.SEDAN : BodyType.getValue(bodyType);
    }

    @Override
    public void pitStop() {
        System.out.println(this.toString() + " pulled into a pit stop");
    }

    @Override
    public void bestTime() {
        System.out.println(this.toString() + " showed the best lap time");
    }

    @Override
    public void maxSpeed() {
        System.out.println(this.toString() + " showed the max speed jn this lap");
    }

    private enum BodyType {
        SEDAN("Седан"),
        HATCHBACK("Хетчбек"),
        COUPE("Купе"),
        WAGON("Универсал"),
        SUV("Внедорожник"),
        CROSSOVER("Кроссовер"),
        PICKUP("Пикап"),
        VAN("Фургон"),
        MINIVAN("Минивэн");

        private final String NAME;

        BodyType(String name) {
            this.NAME = name;
        }

        public String getName() {
            return NAME;
        }

        public static BodyType getValue(String name) {
            for (int i = 0; i < BodyType.values().length; i++) {
                if (BodyType.values()[i].getName().equals(name)) {
                    return BodyType.values()[i];
                }
            }
            return null;
        }

    }
}
