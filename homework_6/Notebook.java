package homework_6;

import java.util.*;

public class Notebook {
    private String brandName;
    private Integer RAM;
    private String OS;
    private String color;

 public Notebook(String brandName, Integer rAM, String oS, String color) {
        this.brandName = brandName;
        RAM = rAM;
        OS = oS;
        this.color = color;
    }

    public String getBrandName() {
        return brandName;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    public Integer getRAM() {
        return RAM;
    }
    public void setRAM(Integer rAM) {
        RAM = rAM;
    }
    public String getOS() {
        return OS;
    }
    public void setOS(String oS) {
        OS = oS;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }



    @Override
    public String toString() {
        return "Notebook{" + "Название: " + brandName + ", ОЗУ: " + RAM + "ГБ"  
        + ", Операционная система: " + OS + ", Цвет: " + color  
        + '}';
    }

    @Override
    public boolean equals (Object obj) {
        if (obj == this)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Notebook))//если объект проверки не является типом Notebook
            return false;
        Notebook other = (Notebook) obj;
        if (this.brandName == other.brandName && this.RAM == other.RAM && this.OS.equals(other.OS)&&
                this.color.equals(other.color))
            return true;
        else return false;
    }
}