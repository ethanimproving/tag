package org.improving.tag.database;

import org.improving.tag.items.UniqueItems;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter(autoApply = true)
public class UniqueItemConverter implements AttributeConverter<UniqueItems,String> {
    @Override
    public String convertToDatabaseColumn(UniqueItems uniqueItems) {
        if(uniqueItems != null){
            return uniqueItems.getName();
        }
        return "";
    }

    @Override
    public UniqueItems convertToEntityAttribute(String s) {
        if(s != null) {
            return Arrays.stream(UniqueItems.values())
                    .filter(ui -> ui.getName().equals(s))
                    .findFirst()
                    .orElse(null);
        }
        return UniqueItems.NOTHING;
    }
}
