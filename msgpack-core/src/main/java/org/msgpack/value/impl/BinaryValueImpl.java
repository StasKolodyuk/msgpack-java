package org.msgpack.value.impl;

import org.msgpack.value.*;

import java.nio.ByteBuffer;

/**
* Created on 5/30/14.
*/
public class BinaryValueImpl extends RawValueImpl implements ImmutableBinaryValue {
    public BinaryValueImpl(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    @Override
    public ValueType getValueType() {
        return ValueType.BINARY;
    }
    @Override
    public void accept(ValueVisitor visitor) {
        visitor.visitBinary(this);
    }

    @Override
    public BinaryValue toValue() {
        return this;
    }



}
