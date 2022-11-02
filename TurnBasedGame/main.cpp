#include <iostream>
#include "Pokemon.hpp"
#include <vector>
#include <cstdlib>
#include <string>
#include <fstream>
int main() {
    srand((int) time(NULL));
    SpecialDefensivePower WaterSpecial("Holy water", 3, 100);
    SpecialOffensivePower EarthSpecial("Holy water", 3, 150);
    SpecialDefensivePower AirSpecial("Fireball", 2,50);
    SpecialOffensivePower FireSpecial("Fireball", 2,200);
    SpecialOffensivePower IceSpecial("Fireball", 2,30);
    SpecialDefensivePower SteelSpecial("Fireball", 2,70);
    Pokemon pokemon1("Charizard", PokemonType::Fire ,FireSpecial,2 , "Male", 15, 200, 100, 500, 3, true, 300);
    Pokemon pokemon2("Bulbasaur", PokemonType::Earth ,EarthSpecial,2 , "Female", 20, 50, 30, 100, 0, false, 20);
    Pokemon pokemon3("Squirtle", PokemonType::Water ,WaterSpecial,5 , "Female", 1 , 75, 60, 76, 0, false, 40);
    Pokemon pokemon4("Spearow", PokemonType::Air ,AirSpecial,6 , "Male", 3 , 50, 30, 0, 435, false, 63);
    Pokemon pokemon5("Poliwag", PokemonType::Water ,WaterSpecial,2 , "Female", 13 , 70, 20, 235, 0, false, 100);
    Pokemon pokemon6("Geodude", PokemonType::Earth ,EarthSpecial,8 , "Male", 8 , 100, 50, 64, 0, false, 154);
    Pokemon pokemon7("Ponyta", PokemonType::Fire, FireSpecial,4 , "Male", 10, 150, 75, 75, 0, false, 235);
    Pokemon pokemon8("Slowpoke", PokemonType::Water, WaterSpecial,6 , "Female", 23, 80, 84, 56, 0, false, 463);
    Pokemon pokemon9("Seel", PokemonType::Ice, IceSpecial,4 , "Female", 17, 110, 30, 64, 0, false, 35);
    Pokemon pokemon10("Cloyster", PokemonType::Ice,IceSpecial, 3 , "Female", 10 , 90, 1, 126, 0, false, 157);
    Pokemon pokemon11("Onix", PokemonType::Earth,EarthSpecial, 5 , "Male", 5 , 300, 125, 321, 0, false, 1000);
    Pokemon pokemon12("Krabby", PokemonType::Water,WaterSpecial, 9 , "Male", 11 , 15, 20, 45, 1, false, 47);
    Pokemon pokemon13("Voltorb", PokemonType::Steel,SteelSpecial, 2 , "Female", 22 , 88, 47, 64, 2, false, 58);
    Pokemon pokemon14("Eevee", PokemonType::Air,AirSpecial, 10 , "Male", 15 , 76, 50, 36, 1, false, 83);
    Pokemon pokemon15("Vaporeon", PokemonType::Water,WaterSpecial, 5 , "Male", 0 , 160, 35, 62, 2, false, 35);
    std::vector<Pokemon> pokemons={pokemon1, pokemon2, pokemon3, pokemon4, pokemon5, pokemon6, pokemon7, pokemon8, pokemon9, pokemon10, pokemon11, pokemon12, pokemon13, pokemon14, pokemon15};
    std::vector<Pokemon> team;
    std::vector<Pokemon> enemies;


    int number,positionTeam=0,positionEnemies=0, winsP=0, winsE=0, round=1,action,difficulty=0;
    std::string help;
    std::cout<<"How many round would you like to play?\n";
    std::cin>>number;
    std::cout<<"Choose difficulty 1-Easy, 2-Medium, 3-Hard\n";
    std::cin>>difficulty;
    while(round<=number){
        bool last=false;
        std::cout<<"If you wish to receive help input -h or -help in the console\n";
        std::cin>>help;
        if(help == "-h" || help == "-help") shortcut();
        team = choose(pokemons);
        enemies = chooseEnemies(pokemons,difficulty);
        std::cout<< "\n";std::cout<< "\n";
        std::cout<<"MY TEAM\n";
        printVec(team);
        std::cout<< "\n";std::cout<< "\n";
        std::cout<< " vs \n";
        std::cout<< "\n";std::cout<< "\n";
        std::cout<< "ENEMY TEAM\n";
        printVec(enemies);
        std::cout<< "\n";std::cout<< "\n";
        bool PlayerWins=false, EnemyWins=false;
        std::cout << "ROUND NUMBER " << number << " HAS STARTED\n";
        std::cout<< "Fight begins\n";
        while(!PlayerWins && !EnemyWins){
            print(team.at(positionTeam));
            std::cout << "\n";
            std::cout << "\n";
            std::cout << " vs \n";
            std::cout << "\n";
            std::cout << "\n";
            std::cout << "Enemy\n";
            print(enemies.at(positionEnemies));
            std::cout << "\n";
            std::cout << "Your turn select your action!\n";
            std::cout << "1-Attack\n";
            std::cout << "2-Use special ability\n";
            std::cout << "3-Change pokemon\n";
            std::cout << "4-Evolve the pokemon\n";
            std::cin >> action;
            if (action == 1) {
                attack(team.at(positionTeam), enemies.at(positionEnemies));
                if (enemies.at(positionEnemies).getHealth() <= 0) {
                    std::cout << "Enemy pokemon has been defeated!!!\n";
                    team.at(positionTeam).setExp(team.at(positionTeam).getExp() + enemies.at(positionEnemies).getXpWorth());
                    winsP++;
                    if (positionEnemies < 3) {
                        positionEnemies++;
                        std::cout << "Enemy's next pokemon is\n";
                        print(enemies.at(positionEnemies));
                        last=true;
                    }
                }
            }
            if (action == 2) {
                useSpecial(team.at(positionTeam), enemies.at(positionEnemies));
                if (enemies.at(positionEnemies).getHealth() <= 0) {
                    std::cout << "Enemy pokemon has been defeated!!!\n";
                    winsP++;
                    team.at(positionTeam).setExp(team.at(positionTeam).getExp() + enemies.at(positionEnemies).getXpWorth());
                    if (positionEnemies < 3) {
                        positionEnemies++;
                        std::cout << "Enemy's next pokemon is\n";
                        print(enemies.at(positionEnemies));
                        last=true;
                    }
                }
            }
            if (action == 3) {
                changePokemon(team);
            }
            if (action == 4) {
                evolution(team.at(positionTeam));
            }
                if(last && enemies.at(positionEnemies).getHealth()<=0){}
                else{
                    std::cout << "Enemy's next pokemon is\n";
                    print(enemies.at(positionEnemies));
                    std::cout << "Opponent's turn!\n";
                    attack(enemies.at(positionEnemies), team.at(positionTeam));
                    if (team.at(positionTeam).getHealth() <= 0) {
                        winsE++;
                        std::cout << "Your pokemon has been defeated!!!\n";
                        if (positionTeam < 5)positionTeam++;
                    }
                }

                if (winsP == 4)PlayerWins = true;
                if (winsE == 6)EnemyWins = true;

        }
        if(PlayerWins){
          std::cout<<"Round " << round << " won by the Player!!!\n";
          round++;
        } else {
          std::cout<<"Round " << round << " won by the Enemy!!!\n";
          round++;
        }
        winsP=0;
        winsE=0;
        PlayerWins=false;
        EnemyWins=false;
        positionTeam=0;
        positionEnemies=0;
      }

  }





