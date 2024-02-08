package nespresso.train.Wagon;

public class WagonFactory {
    public WagonFactory() {
    }
    public String getWagon(WagonType wagonType){
        String resultWagon;
        switch (wagonType){
            case HEAD -> resultWagon = new HeadWagon().getWagon();
            case CARGO -> resultWagon = new CargoWagon().getWagon();
            case PASSENGER -> resultWagon = new PassengerWagon().getWagon();
            case RESTAURANT -> resultWagon = new RestaurantWagon().getWagon();
            case FILLED -> resultWagon = new FilledWagon().getWagon();
            default -> throw new IllegalArgumentException("invalid wagon");
        }
        return resultWagon;
    }
}
