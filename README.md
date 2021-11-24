# kotlin-cli-bazel-crypto-gzip-compress-rsa-encrypted-bcrypt-encoded

## Description
Encrypt and decrypt password with RSA.
To compress the encrypted text gzip was used.

When storing a password it is best practice
to use a one-way hash such as bcrypt, scrypt,
or argon2.

## Tech stack
- kotlin
- bazel

## Docker stack
- l.gcr.io/google/bazel:latest

## To run
`sudo ./install.sh -u`

## To stop (optional)
`sudo ./install.sh -d`

## For help
`sudo ./install.sh -h`

## Credits
- [Correct way to convert string to byte Array] (https://stackoverflow.com/questions/140131/convert-a-string-representation-of-a-hex-dump-to-a-byte-array-using-java)
- [RSA Code] (https://www.geeksforgeeks.org/asymmetric-encryption-cryptography-in-java/)
- [GZIPCompression] (https://stackoverflow.com/questions/16351668/compression-and-decompression-of-string-data-in-java)
