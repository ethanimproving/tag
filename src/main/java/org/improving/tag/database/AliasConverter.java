package org.improving.tag.database;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.List;

@Converter(autoApply = true)
public class AliasConverter implements AttributeConverter<List<String>, String> {
    @Override
    public String convertToDatabaseColumn(List<String> aliasesArr) {
        return String.join(", ", aliasesArr);
    }

    @Override
    public List<String> convertToEntityAttribute(String aliasesDb) {
        return Arrays.asList(aliasesDb.replace(" ", "").split(","));
    }
}
