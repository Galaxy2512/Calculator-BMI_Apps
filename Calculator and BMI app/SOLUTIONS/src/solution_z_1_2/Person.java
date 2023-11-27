package solution_z_1_2;

import java.io.Serializable;

public class Person implements Serializable {

    private float height;
    private float weight;
    private String category;
    private float bmi;


    public Person(float height, float weight, String category, float bmi) {
        this.height = height;
        this.weight = weight;
        this.category = category;
        this.bmi = bmi;
    }

    @Override
    public String toString() {
        return "Person{" +
                "height=" + height +
                ", weight=" + weight +
                ", category='" + category + '\'' +
                ", bmi=" + bmi +
                '}';
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public String getCategory() {
        return category;
    }



    public float getBmi() {
        return bmi;
    }


}
