/*
 * Copyright 2019 Berith foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package berith.caym.protocol.response;

import java.math.BigInteger;

import berith.caym.util.NumericUtil;

/**
 * Berith transaction
 */
public class Transaction {

    private static final int CHAIN_ID_INC = 35;
    private static final int LOWER_REAL_V = 27;

    /**
     * hash of the transaction
     */
    private String hash;
    /**
     * the number of transactions made by the sender prior to this one
     */
    private String nonce;
    /**
     * hash of the block
     */
    private String blockHash;
    /**
     * number of the block
     */
    private String blockNumber;
    /**
     * index position in block
     */
    private String transactionIndex;
    /**
     * address of the sender
     */
    private String from;
    /**
     * address of the receiver. null if contract creation
     */
    private String to;
    /**
     * transferred in Wei
     */
    private String value;
    /**
     * gas price provided by the sender in Wei
     */
    private String gasPrice;
    /**
     * gas provided by the sender
     */
    private String gas;
    /**
     * send along with transaction
     */
    private String input;
    /**
     * ECDSA signature r
     */
    private String r;
    /**
     * ECDSA signature s
     */
    private String s;
    /**
     * ECDSA recovery id
     */
    private long v;
    /**
     * from balance type
     */
    private Type base;
    /**
     * to balance type
     */
    private Type target;
    private String creates;
    private String publicKey;
    private String raw;

    public Transaction() {
    }

    public Transaction(String hash, String nonce, String blockHash, String blockNumber, String transactionIndex, String from,
        String to, String value, String gasPrice, String gas, String input, String r, String s, long v,
        Type base, Type target, String creates, String publicKey, String raw) {
        this.hash = hash;
        this.nonce = nonce;
        this.blockHash = blockHash;
        this.blockNumber = blockNumber;
        this.transactionIndex = transactionIndex;
        this.from = from;
        this.to = to;
        this.value = value;
        this.gasPrice = gasPrice;
        this.gas = gas;
        this.input = input;
        this.r = r;
        this.s = s;
        this.v = v;
        this.base = base;
        this.target = target;
        this.creates = creates;
        this.publicKey = publicKey;
        this.raw = raw;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public BigInteger getNonce() {
        return NumericUtil.decodeQuantity(nonce);
    }

    public String getNonceRaw() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    public BigInteger getBlockNumber() {
        return NumericUtil.decodeQuantity(blockNumber);
    }

    public String getBlockNumberRaw() {
        return blockNumber;
    }

    public void setBlockNumber(String blockNumber) {
        this.blockNumber = blockNumber;
    }

    public BigInteger getTransactionIndex() {
        return NumericUtil.decodeQuantity(transactionIndex);
    }

    public String getTransactionIndexRaw() {
        return transactionIndex;
    }

    public void setTransactionIndex(String transactionIndex) {
        this.transactionIndex = transactionIndex;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigInteger getValue() {
        return NumericUtil.decodeQuantity(value);
    }

    public String getValueRaw() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public BigInteger getGasPrice() {
        return NumericUtil.decodeQuantity(gasPrice);
    }

    public String getGasPriceRaw() {
        return gasPrice;
    }

    public void setGasPrice(String gasPrice) {
        this.gasPrice = gasPrice;
    }

    public BigInteger getGas() {
        return NumericUtil.decodeQuantity(gas);
    }

    public String getGasRaw() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public long getV() {
        return v;
    }

    public Long getChainId() {
        if (v == LOWER_REAL_V || v == (LOWER_REAL_V + 1)) {
            return null;
        }
        Long chainId = (v - CHAIN_ID_INC) / 2;
        return chainId;
    }

    public void setV(Object v) {
        if (v instanceof String) {
            this.v = NumericUtil.toBigInt((String) v).longValueExact();
        } else if (v instanceof Integer) {
            this.v = ((Integer) v).longValue();
        } else {
            this.v = (Long) v;
        }
    }

    public void setBase(int value) {
        base = Type.valueOf(value);
    }

    public Type getBase() {
        return base;
    }

    public void setTarget(int value) {
        target = Type.valueOf(value);
    }

    public Type getTarget() {
        return target;
    }

    public String getCreates() {
        return creates;
    }

    public void setCreates(String creates) {
        this.creates = creates;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof org.web3j.protocol.core.methods.response.Transaction)) {
            return false;
        }

        org.web3j.protocol.core.methods.response.Transaction that = (org.web3j.protocol.core.methods.response.Transaction) o;

        if (getV() != that.getV()) {
            return false;
        }
        if (getHash() != null ? !getHash().equals(that.getHash()) : that.getHash() != null) {
            return false;
        }
        if (getNonceRaw() != null
            ? !getNonceRaw().equals(that.getNonceRaw()) : that.getNonceRaw() != null) {
            return false;
        }
        if (getBlockHash() != null
            ? !getBlockHash().equals(that.getBlockHash()) : that.getBlockHash() != null) {
            return false;
        }
        if (getBlockNumberRaw() != null
            ? !getBlockNumberRaw().equals(that.getBlockNumberRaw())
            : that.getBlockNumberRaw() != null) {
            return false;
        }
        if (getTransactionIndexRaw() != null
            ? !getTransactionIndexRaw().equals(that.getTransactionIndexRaw())
            : that.getTransactionIndexRaw() != null) {
            return false;
        }
        if (getFrom() != null ? !getFrom().equals(that.getFrom()) : that.getFrom() != null) {
            return false;
        }
        if (getTo() != null ? !getTo().equals(that.getTo()) : that.getTo() != null) {
            return false;
        }
        if (getValueRaw() != null
            ? !getValueRaw().equals(that.getValueRaw()) : that.getValueRaw() != null) {
            return false;
        }
        if (getGasPriceRaw() != null
            ? !getGasPriceRaw().equals(that.getGasPriceRaw()) : that.getGasPriceRaw() != null) {
            return false;
        }
        if (getGasRaw() != null
            ? !getGasRaw().equals(that.getGasRaw()) : that.getGasRaw() != null) {
            return false;
        }
        if (getInput() != null ? !getInput().equals(that.getInput()) : that.getInput() != null) {
            return false;
        }
        if (getCreates() != null
            ? !getCreates().equals(that.getCreates()) : that.getCreates() != null) {
            return false;
        }
        if (getPublicKey() != null
            ? !getPublicKey().equals(that.getPublicKey()) : that.getPublicKey() != null) {
            return false;
        }
        if (getRaw() != null ? !getRaw().equals(that.getRaw()) : that.getRaw() != null) {
            return false;
        }
        if (getR() != null ? !getR().equals(that.getR()) : that.getR() != null) {
            return false;
        }
        return getS() != null ? getS().equals(that.getS()) : that.getS() == null;
    }

    @Override
    public int hashCode() {
        int result = getHash() != null ? getHash().hashCode() : 0;
        result = 31 * result + (getNonceRaw() != null ? getNonceRaw().hashCode() : 0);
        result = 31 * result + (getBlockHash() != null ? getBlockHash().hashCode() : 0);
        result = 31 * result + (getBlockNumberRaw() != null ? getBlockNumberRaw().hashCode() : 0);
        result = 31 * result
            + (getTransactionIndexRaw() != null ? getTransactionIndexRaw().hashCode() : 0);
        result = 31 * result + (getFrom() != null ? getFrom().hashCode() : 0);
        result = 31 * result + (getTo() != null ? getTo().hashCode() : 0);
        result = 31 * result + (getValueRaw() != null ? getValueRaw().hashCode() : 0);
        result = 31 * result + (getGasPriceRaw() != null ? getGasPriceRaw().hashCode() : 0);
        result = 31 * result + (getGasRaw() != null ? getGasRaw().hashCode() : 0);
        result = 31 * result + (getInput() != null ? getInput().hashCode() : 0);
        result = 31 * result + (getCreates() != null ? getCreates().hashCode() : 0);
        result = 31 * result + (getPublicKey() != null ? getPublicKey().hashCode() : 0);
        result = 31 * result + (getRaw() != null ? getRaw().hashCode() : 0);
        result = 31 * result + (getR() != null ? getR().hashCode() : 0);
        result = 31 * result + (getS() != null ? getS().hashCode() : 0);
        result = 31 * result + BigInteger.valueOf(getV()).hashCode();
        return result;
    }

    public enum Type {
        UNKNOWN(-1), MAIN(1), STAKE(2);

        private int value;

        Type(int value) {
            this.value = value;
        }

        static Type valueOf(int value) {
            switch (value) {
                case 1:
                    return MAIN;
                case 2:
                    return STAKE;
                default:
                    return UNKNOWN;
            }
        }
    }
}
