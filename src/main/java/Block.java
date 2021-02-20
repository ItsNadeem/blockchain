import java.util.Date;

public class Block {
    public String previousHash;
    public String hash;
    private String data;
    private long timestamp;
    private int nonce;

    Block(String data, String previousHash) {
        this.previousHash = previousHash;
        this.data = data;
        this.timestamp = new Date().getTime();
        this.hash = calculateHash();

    }

    public String calculateHash() {
        return StringUtil.applySHA256(previousHash + Long.toString(timestamp) + Integer.toString(nonce) + data);
    }

    public void mineBlock(int difficulty) {

        //Create a string with difficulty * "0"
        String target = new String(new char[difficulty]).replace('\0', '0');
        while(!hash.substring( 0, difficulty).equals(target)) {
            nonce ++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }
}
