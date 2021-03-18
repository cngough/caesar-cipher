package uk.chrisgough.caesarcipher.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CipherResponse {

    @JsonProperty("plaintext")
    private final String plainText;

    public CipherResponse(String plainText) {

        this.plainText = plainText;
    }

    public String getPlainText() {

        return this.plainText;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CipherResponse that = (CipherResponse) o;

        return new EqualsBuilder().append(plainText, that.plainText).isEquals();
    }

    @Override
    public int hashCode() {

        return new HashCodeBuilder(17, 37).append(plainText).toHashCode();
    }

    @Override
    public String toString() {

        return new ToStringBuilder(this)
                .append("plainText", plainText)
                .toString();
    }
}
