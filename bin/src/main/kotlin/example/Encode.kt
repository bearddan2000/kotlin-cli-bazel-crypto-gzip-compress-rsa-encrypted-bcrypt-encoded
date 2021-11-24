package example

import org.mindrot.jbcrypt.*;
import java.io.IOException;
import javax.xml.bind.DatatypeConverter;

class Encode {

  @Throws(IOException::class)
  fun compress(hash: String): ByteArray {
    val compress: ByteArray? = GZIPCompression.compress(hash);

    if(compress == null)
    {
      println(String.format("The Encrypted Compressed Text length is: %d", -1));

      return ByteArray(0)
    }

    return compress
  }

  @Throws(IOException::class)
  fun decompress(hash: ByteArray): String {
    return GZIPCompression.decompress(hash);
  }

  @Throws(Exception::class)
  fun encrypt(rsa: Encryption, hash: String): ByteArray {

    val cipherText: ByteArray = rsa.do_RSAEncryption(hash);

    val newHash: String = DatatypeConverter.printHexBinary(cipherText);

    return compress(newHash);
  }

  @Throws(Exception::class)
  fun decrypt(rsa: Encryption, hash: ByteArray): String {

    val decompress: String = decompress(hash);

    return rsa.do_RSADecryption(DatatypeConverter.parseHexBinary(decompress));
  }

  fun hashpw(rsa: Encryption, pass: String): String {

    val stored: String = BCrypt.hashpw(pass, BCrypt.gensalt());

    try {

      val newHash: ByteArray = encrypt(rsa, stored);

      return DatatypeConverter.printHexBinary(newHash);

    } catch (e: Exception) {

      return "";
    }

  }

  fun verify(rsa: Encryption, pass :String, hash: String): Boolean {

    val hashArray: ByteArray = DatatypeConverter.parseHexBinary(hash);

    try{

      val newHash: String = decrypt(rsa, hashArray);

      return BCrypt.checkpw(pass, newHash);

    } catch (e: Exception) {

      println("Encode verify error");

      e.printStackTrace();

      return false;
    }
  }
}
