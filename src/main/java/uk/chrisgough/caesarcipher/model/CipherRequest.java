package uk.chrisgough.caesarcipher.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class CipherRequest {

    @JsonProperty("ciphertext")
    private final String cipherText;
    private final List<String> cribs;

    public CipherRequest(String cipherText, List<String> cribs) {

        this.cipherText = cipherText;
        this.cribs = cribs;
    }

    public String getCipherText() {

        return cipherText;
    }

    public List<String> getCribs() {

        return cribs;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CipherRequest that = (CipherRequest) o;

        return new EqualsBuilder().append(cipherText, that.cipherText).append(cribs, that.cribs).isEquals();
    }

    @Override
    public int hashCode() {

        return new HashCodeBuilder(17, 37).append(cipherText).append(cribs).toHashCode();
    }

    @Override
    public String toString() {

        return new ToStringBuilder(this)
                .append("cipherText", cipherText)
                .append("cribs", cribs)
                .toString();
    }
}
