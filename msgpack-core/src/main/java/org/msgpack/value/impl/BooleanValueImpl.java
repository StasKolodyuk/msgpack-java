package org.msgpack.value.impl;

import org.msgpack.core.MessagePacker;
import org.msgpack.value.*;

import java.io.IOException;

/**
* Created on 5/30/14.
*/
public class BooleanValueImpl extends AbstractValue implements ImmutableBooleanValue {

    public static BooleanValue TRUE = new BooleanValueImpl(true);
    public static BooleanValue FALSE = new BooleanValueImpl(false);

    private final boolean value;

    public BooleanValueImpl(boolean value) {
        this.value = value;
    }

    @Override
    public ValueType getValueType() {
        return ValueType.BOOLEAN;
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BooleanValue))
            return false;
        return value == ((BooleanValue) o).toBoolean();
    }

    @Override
    public int hashCode() {
        return value ? 1 : 0;
    }

    public String toString() {
        return Boolean.toString(value);
    }

    @Override
    public boolean toBoolean() {
        return value;
    }
    @Override
    public BooleanValue toValue() {
        return null;
    }

    @Override
    public void writeTo(MessagePacker packer) throws IOException {
        packer.packBoolean(value);
    }
    @Override
    public void accept(ValueVisitor visitor) {
        visitor.visitBoolean(value);
    }

    @Override
    public BooleanValue toImmutable() {
        return this;
    }

    @Override
    public boolean isImmutable() {
        return true;
    }


}
