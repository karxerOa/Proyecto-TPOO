/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author apnil
 */
public class ThemeColor {
    private static Color primaryColor;
    private static Color secondaryColor;

    public static final List<String> colorList = Arrays.asList(
        "#3F51B5", "#009688", "#FF5722", "#607D8B", "#FF9800", "#9C27B0",
        "#2196F3", "#EA676C", "#E41A4A", "#5978BB", "#018790", "#0E3441",
        "#00B0AD", "#721D47", "#EA4833", "#EF937E", "#F37521", "#A12059",
        "#126881", "#8BC240", "#364D5B", "#C7DC5B", "#0094BC", "#E4126B",
        "#43B76E", "#7BCFE9", "#B71C46"
    );

    public static Color getPrimaryColor() {
        return primaryColor;
    }

    public static void setPrimaryColor(Color color) {
        primaryColor = color;
    }

    public static Color getSecondaryColor() {
        return secondaryColor;
    }

    public static void setSecondaryColor(Color color) {
        secondaryColor = color;
    }
}
