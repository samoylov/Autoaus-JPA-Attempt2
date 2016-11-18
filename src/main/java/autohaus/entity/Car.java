package autohaus.entity;

import javax.persistence.*;

@Entity
public class Car implements Comparable<Car> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private CarModel carModel;
    @ManyToOne
    private Engine engine;
    @ManyToOne
    private Transmission transmission;
    @ManyToOne
    private Color color;
    private int price;

    public Car() {
    }

    public Car(CarModel carModel, Engine engine, Transmission transmission, Color color,
               int price) {
        super();
        this.carModel = carModel;
        this.engine = engine;
        this.transmission = transmission;
        this.color = color;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((engine == null) ? 0 : engine.hashCode());
        result = prime * result + ((carModel == null) ? 0 : carModel.hashCode());
        result = prime * result + price;
        result = prime * result + ((transmission == null) ? 0 : transmission.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Car other = (Car) obj;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        if (engine == null) {
            if (other.engine != null)
                return false;
        } else if (!engine.equals(other.engine))
            return false;
        if (carModel == null) {
            if (other.carModel != null)
                return false;
        } else if (!carModel.equals(other.carModel))
            return false;
        if (price != other.price)
            return false;
        if (transmission == null) {
            if (other.transmission != null)
                return false;
        } else if (!transmission.equals(other.transmission))
            return false;
        return true;
    }

    public int compareTo(Car o) {
        String thisData = carModel.getMake().getName() + carModel.toString() + engine.toString()
                + transmission.toString() + color.toString() + String.format("%d", price);
        String oData = o.getCarModel().getMake().getName() + o.getCarModel().toString()
                + o.getEngine().toString() + o.getTransmission().toString()
                + o.getColor().toString() + String.format("%d", o.getPrice());
        int diff = thisData.compareTo(oData);
        if (diff != 0)
            return diff;
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%02d: %s %s, %s, %s, %s, $%d", id,
                carModel.getMake().getName(), carModel.getName(), engine.getName(),
                transmission.getName(), color.getName(), price);
    }

}
