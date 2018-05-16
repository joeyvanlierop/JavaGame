package level;

import gfx.Sprite;
import gfx.SpriteSheet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import tiles.Tile;
import tiles.TileManager;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public final class TiledMapLoader
{
    public static TiledMap loadMap(String mapPath, String tileSetPath)
    {
        JSONObject mapFile = loadFile(mapPath);
        JSONObject tileSetFile = loadFile(tileSetPath);

        long width = (Long) mapFile.get("width");
        long height = (Long) mapFile.get("height");
        ArrayList<TiledMapLayer> mapLayers = new ArrayList<>();
        ArrayList<Tile> tiles = new ArrayList<>();
        SpriteSheet tileSet = null;

        {
            JSONArray tileSets = (JSONArray) mapFile.get("tilesets");
            Iterator<JSONObject> i = tileSets.iterator();
            while (i.hasNext())
            {
                JSONObject innerObj = i.next();

                tileSet = new SpriteSheet((String) innerObj.get("image"));
            }
        }

        {
            JSONArray layers = (JSONArray) mapFile.get("layers");
            Iterator<JSONObject> i = layers.iterator();
            while (i.hasNext())
            {
                JSONObject innerObj = i.next();

                long layerWidth = (Long) innerObj.get("width");
                long layerHeight = (Long) innerObj.get("height");

                JSONArray array = (JSONArray) innerObj.get("data");
                int[] layerData = new int[array.size()];

                for (int j = 0; j < array.size(); j++)
                {
                    layerData[j] = ((Long) array.get(j)).intValue();
                }

                mapLayers.add(new TiledMapLayer(layerWidth, layerHeight, layerData));
            }
        }

        {
            long imageWidth = (Long) tileSetFile.get("imagewidth");
            long imageHeight = (Long) tileSetFile.get("imageheight");
            JSONObject tileProperties = (JSONObject) tileSetFile.get("tileproperties");

            for(int y = 0; y < imageHeight / 16; y++)
            {
                for(int x = 0; x < imageWidth / 16; x++)
                {
                    int id = x + y * ((int) imageWidth / 16);
                    JSONObject tile = (JSONObject) tileProperties.get(Integer.toString(id));
                    boolean solid = (boolean) tile.get("solid");

                    tiles.add(new Tile(id, solid, new Sprite(x * 16, y * 16,16, 16, tileSet)));
                }
            }
        }

        try
        {
            return new TiledMap(width, height, new TileManager(tiles), mapLayers);
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    private static JSONObject loadFile(String path)
    {
        JSONObject file = null;

        try
        {
            URL resource = TiledMapLoader.class.getResource(path);
            file = (JSONObject) new JSONParser().parse(new FileReader(new File(resource.getFile())));
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (ParseException e)
        {
            e.printStackTrace();
        }

        return file;
    }
}
