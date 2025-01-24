import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   32405
 * @problemTitle    배틀 로얄
 */
public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Player> players = new ArrayDeque<>();

        String[] tokensAtk = br.readLine().split(" ");
        String[] tokensHp = br.readLine().split(" ");
        for (int i = 0; i < N; ++i) {
            int atk = Integer.parseInt(tokensAtk[i]);
            int hp = Integer.parseInt(tokensHp[i]);

            players.offer(new Player(i + 1, hp, atk));
        }
        tokensAtk = null;
        tokensHp = null;

        int damage = 0;
        Player player;
        while (players.size() > 1) {
            player = players.poll();

            if (player.hp - damage + (player.atk * player.cycle) <= 0) continue;

            damage += player.atk;
            ++player.cycle;

            players.offer(player);
        }

        player = players.poll();
        bw.write(player.no + "\n");
        bw.flush();

        bw.close();
        br.close();
    }
}

class Player {
    int no;
    int hp;
    int atk;
    int cycle;

    public Player(int no, int hp, int atk) {
        this.no = no;
        this.hp = hp;
        this.atk = atk;
        this.cycle = 0;
    }

    @Override
    public String toString() {
        return String.format("[%d](hp=%d, atk=%d)", no, hp, atk);
    }
}