/**
 * 
 */
package core_classes;

<<<<<<< HEAD
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import toolset.Settings;
=======
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;
>>>>>>> 6ffccaecdd878b743b1980c68714807e148bdff7

/**
 * @author Isaac
 *
 */
<<<<<<< HEAD
public class Layer  {
	
	private Object[] tableData = {};
	
	private List<Feature> listOfFeatures = new ArrayList<Feature>();
	
	private String layerName = "";
	private String layerType = "";
	private Color layerColor = Settings.DEFAULT_LAYER_COLOR;
	
	private boolean isVisible = true;
	private boolean notSaved = true;
	
	private int id = 0;
	
	/**
	 * @param id
	 * @param layerName
	 * @param isActive
	 * @param layerColor
	 * @param layerType
	 */
	public Layer(int id, boolean isVisible, String layerType,  String layerName) {
		//super(id);
		this.id = id;
		this.layerName = layerName;
		this.isVisible = isVisible;
		this.layerType = layerType;
		this.tableData = new Object[] {isVisible, layerType, layerName, "", id};
		
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the tableData
	 */
	public Object[] getTableData() {
		return tableData;
	}

	/**
	 * @return the layerName
	 */
	public String getLayerName() {
		return layerName;
	}

	/**
	 * @param layerName the layerName to set
	 */
	public void setLayerName(String layerName) {
		this.layerName = layerName;
	}

	/**
	 * @return the isActive
	 */
	public boolean isVisible() {
		return isVisible;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	/**
	 * @return the layerColor
	 */
	public Color getLayerColor() {
		return layerColor;
	}

	/**
	 * @param layerColor the layerColor to set
	 */
	public void setLayerColor(Color layerColor) {
		this.layerColor = layerColor;
	}

	/**
	 * @return the layerType
	 */
	public String getLayerType() {
		return layerType;
	}

	/**
	 * @param layerType the layerType to set
	 */
	public void setLayerType(String layerType) {
		this.layerType = layerType;
	}

	/**
	 * @return the notSaved
	 */
	public boolean isNotSaved() {
		return notSaved;
	}

	/**
	 * @param notSaved the notSaved to set
	 */
	public void setNotSaved(boolean notSaved) {
		this.notSaved = notSaved;
	}

	/**
	 * @return the listOfFeatures
	 */
	public List<Feature> getListOfFeatures() {
		return listOfFeatures;
	}

	/**
	 * @param listOfFeatures the listOfFeatures to set
	 */
	public void setListOfFeatures(List<Feature> listOfFeatures) {
		this.listOfFeatures = listOfFeatures;
	}

	public int getNextID() {
=======
public class Layer {

    private Feature geometryType;
    private ArrayList<Feature> featureList;

    private String name;
    private Color color;
    private int weight;

    private boolean editSession;
    private boolean visible;


    /**
     * Constructor for creating a blank new layer
     * @param geometryType generic PointItem, PolylineItem or PolygonItem object to indicate geometry type of this layer.
     */
    public Layer(Feature geometryType, String name) {

        this.geometryType = geometryType;
        this.featureList = new ArrayList<Feature>(0);

        this.name = name;
        // I'm using HSB instead of RGB because it makes sure that the colour can be random but we won't get anything too close to white or black.
        this.color = Color.getHSBColor(new Random().nextInt(255), 50, 100);
        this.weight = 1;

        this.editSession = false;
        this.visible = true;
    }

    /**
     * Constructor for creating a layer with the contents of a database table.
     * @param resultSet a ResultSet returned from the database
     */
    public Layer(ResultSet resultSet) {
        //TODO: make Layer constructor for database ResultSet
    }

    /**
     * Constructor for creating a layer from a CSV file.
     * @param bufferedReader BufferedReader on a CSV file.
     */
    public Layer(BufferedReader bufferedReader) {
        //TODO: make Layer constructor for CSV BufferedReader
    }

    /**
     * Getter method for the features contained in this layer.
     * @return ArrayList of features in featureList.
     */
    public ArrayList<Feature> getFeatureList() {
        return this.featureList;
    }

    /**
     * Gets the next id value based on what is already in the layer.  Using this will ensure that the id counter will
     * only get get higher, even if features are deleted.  Therefore, the last element in the featureList plus one will
     * always be the next id.  If featureList is empty, just return 0.
     * @return integer representing the next id to be used when adding a new feature.
     */
    public int getNextId() {
        if (this.featureList.size() != 0) {
            return this.featureList.get(this.featureList.size()-1).getId() + 1;
        } else {
            return 0;
        }
    }

    /**
     * Changes the layer's name to the input string.
     * @param name String to change the layer's name to.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Changes the layer's color to the input color.
     * @param color Color object to change the layer to.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Getter method for feature color
     * @return Color representing feature color.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Getter method for feature weight.
     * @return Integer representing feature weight.
     */
    public int getWeight() {
        return this.weight;
    }

    /**
     * Change's the layer's weight to the input weight.
     * @param weight weight to change the layer to.
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Toggles the layer to be under an edit session or not.
     */
    public void toggleEditSession() {
        this.editSession = !this.editSession;
    }

    /**
     * TOggle's the layer to be visible or not.
     */
    public void toggleVisibility() {
        this.visible = !this.visible;
    }

    /**
     * Adds a feature to the featureList.
     * @param feature feature to be added to this layer's featureList.
     */
    public void addFeature(Feature feature) {
        // I want to use instanceof here but it won't work.
        if (feature.getClass() == this.geometryType.getClass()) {
            this.featureList.add(feature);
        } else {
            throw new IllegalArgumentException("Layer " + this.name + " is of " + this.geometryType.getClass() + " type and it received a " + feature.getClass() + " feature.");
        }
    }

    /**
     * Removes a feature from the featureList by its id.
     * @param id id of the Feature to be removed.
     */
    public void removeFeature(int id) {
        for (int i=0; i<this.featureList.size(); i++) {
            if (this.featureList.get(i).getId() == id) {
                this.featureList.remove(i);
            }
        }
    }

    /**
     * Writes the contents of the featureList to CSV
     * @param csvWriter BufferedReader to use to write to CSV file.
     */
    public void exportToCSV(BufferedWriter csvWriter) {
        //TODO: make layer able to export to CSV
    }
>>>>>>> 6ffccaecdd878b743b1980c68714807e148bdff7

		return this.listOfFeatures.size() + 1;
	}
	
}
