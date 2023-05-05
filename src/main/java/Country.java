class Country {
    private String code;
    private String name;
    private int population;

    public Country(String code, String name, int population) {
        this.code = code;
        this.name = name;
        this.population = population;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) ma %d ludności.", name, code, population);
    }
}
