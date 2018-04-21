package br.edu.ifpb.atividadecolaborativa.rest;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

/**
 * Created by laerton on 18/04/2018.
 */

public class DateDeserializer implements JsonDeserializer<Date> {
    private static final String[] DATE_FORMATS = new String[]{
            "MMM-dd-yy HH:mm:ss",
            "MMM dd, yyyy",
            "dd/MM/yyyy",
            "mmm dd, yyyy",
            "yyyy/MM/dd",
            "yyyy-MM-dd",
            "dd-MM-yyyy"
    };
    @Override
    public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        for (String format : DATE_FORMATS) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yy HH:mm:ss", new Locale("pt", "BR"));
                //Date dt = new Date();
                Date dt = new Date();
                dt.setTime(Long.parseLong(jsonElement.getAsString()));

                return  dt; //sdf.parse(jsonElement.getAsString());
            } catch (Exception e) {
                throw new JsonParseException("Unparseable date: \"" + jsonElement.getAsString()
                        + "\". Supported formats: " + Arrays.toString(DATE_FORMATS));
            }
        }
        return  null;

    }
}
