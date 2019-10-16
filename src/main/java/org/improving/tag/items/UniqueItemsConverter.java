package org.improving.tag.items;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class UniqueItemsConverter implements AttributeConverter<UniqueItems, String> {

    // Take in unique item from entity class and store as string in db.
    public String convertToDatabaseColumn(UniqueItems item) {
//        this.setItem(Arrays
//                .stream(UniqueItems.values())
//                .filter(item -> item.getName().equals(dropItemDb))
//                .findFirst()
//                .orElse(null));
        return "test string";
    }

    // Take in string from database and find matching unique item in entity class.
    @Override
    public UniqueItems convertToEntityAttribute(String item) {
        return UniqueItems.NOTHING;
    }

}
