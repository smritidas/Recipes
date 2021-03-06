

package db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * NB This is the Entity class
 * TODO - ask how to rename this?
 */

@androidx.room.Entity(tableName = "savedRecipe_table")
public class Entry {

    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String name;

    @ColumnInfo
    private String imageURL;

    @ColumnInfo
    private String url;

    @ColumnInfo
    private int noOfServings;

    public String getName() {
        return name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getUrl() {
        return url;
    }

    public int getNoOfServings() {
        return noOfServings;
    }

    public int getId() {
        return id;
    }

    public Entry(int id, String name, String imageURL, String url, int noOfServings) {
        this.id = id;
        this.name = name;
        this.imageURL = imageURL;
        this.url = url;
        this.noOfServings = noOfServings;
    }
}
