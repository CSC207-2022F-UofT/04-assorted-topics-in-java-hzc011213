/* TODO: Create a subclass of Trader named DrivableTrader
 * This class should be identical to Trader, except that it takes
 * only Drivable objects in its inventory, wishlist, etc.
 *
 * The DrivableTrader returned should also be overridden. The selling price
 * should be equal to the:
 *     Object's price + Object's max maxSpeed
 * If the object is Tradable (and Tradable.MISSING_PRICE otherwise.)
 *
 * Look at DomesticatableTrader.java for an example.
 */

import java.util.List;
class DrivableTrader extends Trader<Drivable> {

    private int maxSpeed;

    public DrivableTrader(List<Drivable> inventory, List<Drivable> wishlist, int money, int maxSpeed) {
        super(inventory, wishlist, money);
        this.maxSpeed = maxSpeed;
    }

    public DrivableTrader(int money) {
        super(money);
        this.maxSpeed = 0;
    }

    @Override
    public int getSellingPrice(Drivable item){
        if (item instanceof Tradable){
            return ((Tradable) item).getPrice() + item.getMaxSpeed();
        } else {
            return Tradable.MISSING_PRICE;
        }
    }

    private int getMaxSpeed() {
        return this.maxSpeed;
    }


}