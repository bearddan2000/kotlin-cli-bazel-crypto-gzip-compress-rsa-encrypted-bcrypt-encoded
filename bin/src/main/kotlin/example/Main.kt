/*
 * copyright
 * http://timarcher.com/blog/2007/04/simple-java-class-to-des-encrypt-strings-such-as-passwords-and-credit-card-numbers/
 */

package example;

fun printVerify(pass1: String, pass2: String, test: Boolean)
{
  val baseStr: String = String.format("%s, %s", pass1, pass2)

  if(test) {
    println(String.format("%s Match: True", baseStr))
  } else {
    println(String.format("%s Match: False", baseStr))
  }
}

// Driver code
@Throws(Exception::class)
fun main(args: Array<String>)
{
    val rsa: Encryption = Encryption();

    val encode: Encode = Encode()

    val hash: String = encode.hashpw(rsa, "pass123");

    val test1: Boolean = encode.verify(rsa, "pass123", hash);

    val test2: Boolean = encode.verify(rsa, "123pass", hash);

    printVerify("pass123", "pass123", test1)

    printVerify("pass123", "123pass", test2)
}
