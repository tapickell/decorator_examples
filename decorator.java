package me.toddpickell.decorator;

/**
 *  a Java app to demonstrate decorator pattern
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        Box box = new RealBox();
        System.out.println( "Box color: " + box.getColor() );
        System.out.println( "Box volume: " + box.getVolume() );

	box = new CardboardBox(box);
        System.out.println( "Box color: " + box.getColor() );
        System.out.println( "Box volume: " + box.getVolume() );
	System.out.println( "Box material: " + box.material() );

	box = new WetCardboardBox(box);
        System.out.println( "Box color: " + box.getColor() );
        System.out.println( "Box volume: " + box.getVolume() );
	System.out.println( "Box material: " + box.material() );
	System.out.println( "Box condition: " + box.condition() );

	box = new GoldenBox(box);
        System.out.println( "Box color: " + box.getColor() );
        System.out.println( "Box volume: " + box.getVolume() );
	System.out.println( "Box material: " + box.material() );
    }
}

public absract class Box {
    public abstract String getColor();
    public abstract Integer getVolume();
}

public class RealBox extends Box {
    public String getColor() {
        return "Blue";
    }

    public Integer getVolume() {
        return 10;
    }
}

public abstract class BoxDecorator extends Box {
    protected final Box decoratedBox;

    protected BoxDecorator(Box decoratedBox) {
        this.decoratedBox = decoratedBox;
    }

    public String getColor() {
        return decoratedBox.getColor();
    }

    public Integer getVolume() {
        return decoratedBox.getVolume();
    }

    public abstract String getMaterial();
}

class CardboardBox extends BoxDecorator {
    public CardboardBox(Box decoratedBox) {
        super(decoratedBox);
    }

    public String getColor() {
        return "Brown";
    }

    public Integer getVolume() {
        return super.getVolume() + 5;
    }

    public String getMaterial() {
        return "Cardboard";
    }
}   

class WetCardboardBox extends CardboardBox {
    public WetCardboardBox(Box decoratedBox) {
        super.CardboardBox(decoratedBox);
    }

    public String Condition() {
        return "Soaked";
    }
}

class GoldenBox extends BoxDecorator {
    public GoldenBox(Box decoratedBox) {
        super(decoratedBox);
    }

    public String getColor() {
        return "Gold";
    } 

    public Integer getVolume() {
        return super.getVolume() - 5;
    }

    public String getMaterial() {
        return "24k Gold";
    }
}
