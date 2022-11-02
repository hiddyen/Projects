#include "Pokemon.hpp"
#include "SpecialPower.hpp"
#include <iostream>
#include <cmath>
#include <cstdlib>
#include <vector>



auto print(Pokemon&)-> void;
auto printVec(std::vector<Pokemon>&)-> void;
auto getType(Pokemon*)-> void;
auto evolution(Pokemon&) ->void;
auto attack(Pokemon&, Pokemon&)-> void;
auto useSpecial(Pokemon&, Pokemon&)->void;
auto multiplier(Pokemon&, Pokemon&)->double;
auto fullHp(Pokemon&)->int;
auto operator<<(std::ostream& ostream, PokemonType const t) -> std::ostream&;
auto choose(std::vector<Pokemon>&)->std::vector<Pokemon>;
auto changePokemon(std::vector<Pokemon>&)->void;
auto chooseEnemies(std::vector<Pokemon>&,int)->std::vector<Pokemon>;
auto shortcut()->void;

Pokemon::Pokemon(std::string name1, PokemonType type1,SpecialDefensivePower powerD1,int specialPowerUsages1, std::string gender1, int dexterity1, double health1, double attackDmg1, int exp1, int evo1, bool finalEvo1, int xpWorth1):
                name(name1), type(type1), powerD(powerD1), specialPowerUsages(specialPowerUsages1), gender(gender1), dexterity(dexterity1), health(health1), attackDmg(attackDmg1), exp(exp1), evo(evo1), finalEvo(finalEvo1), xpWorth(xpWorth1){}
Pokemon::Pokemon(std::string name1, PokemonType type1,SpecialOffensivePower powerO1,int specialPowerUsages1, std::string gender1, int dexterity1, double health1, double attackDmg1, int exp1, int evo1, bool finalEvo1, int xpWorth1):
        name(name1), type(type1), powerO(powerO1), specialPowerUsages(specialPowerUsages1), gender(gender1), dexterity(dexterity1), health(health1), attackDmg(attackDmg1), exp(exp1), evo(evo1), finalEvo(finalEvo1), xpWorth(xpWorth1){}

void Pokemon::setType(PokemonType type) {
    Pokemon::type = type;
}

void Pokemon::setPowerO(const SpecialOffensivePower &powerO) {
    Pokemon::powerO = powerO;
}

void Pokemon::setPowerD(const SpecialDefensivePower &powerD) {
    Pokemon::powerD = powerD;
}

void Pokemon::setWeight(double weight) {
    Pokemon::weight = weight;
}

void Pokemon::setHeight(double height) {
    Pokemon::height = height;
}

void Pokemon::setGender(const std::string &gender) {
    Pokemon::gender = gender;
}

void Pokemon::setSpecialPowerUsages(int specialPowerUsages) {
    Pokemon::specialPowerUsages = specialPowerUsages;
}

void Pokemon::setEvo(int evo) {
    Pokemon::evo = evo;
}

void Pokemon::setFinalEvo(bool finalEvo) {
    Pokemon::finalEvo = finalEvo;
}

void Pokemon::setXpWorth(int xpWorth) {
    Pokemon::xpWorth = xpWorth;
}

void Pokemon::setName(const std::string &name) {
    Pokemon::name = name;
}

void Pokemon::setAttackDmg(int attackDmg) {
    Pokemon::attackDmg = attackDmg;
}

void Pokemon::setDexterity(int dexterity) {
    Pokemon::dexterity = dexterity;
}

void Pokemon::setHealth(int health) {
    Pokemon::health = health;
}

void Pokemon::setExp(int exp) {
    Pokemon::exp = exp;
}

void Pokemon::setMaxHp(int maxHp) {
    Pokemon::maxHp = maxHp;
}

PokemonType Pokemon::getType1() const {
    return type;
}

const SpecialOffensivePower &Pokemon::getPowerO() const {
    return powerO;
}

const SpecialDefensivePower &Pokemon::getPowerD() const {
    return powerD;
}

double Pokemon::getWeight() const {
    return weight;
}

double Pokemon::getHeight() const {
    return height;
}

const std::string &Pokemon::getGender() const {
    return gender;
}

int Pokemon::getSpecialPowerUsages() const {
    return specialPowerUsages;
}

int Pokemon::getEvo() const {
    return evo;
}

bool Pokemon::isFinalEvo() const {
    return finalEvo;
}

int Pokemon::getXpWorth() const {
    return xpWorth;
}

const std::string &Pokemon::getName() const {
    return name;
}

int Pokemon::getAttackDmg() const {
    return attackDmg;
}

int Pokemon::getDexterity() const {
    return dexterity;
}

int Pokemon::getHealth() const {
    return health;
}

int Pokemon::getExp() const {
    return exp;
}

int Pokemon::getMaxHp() const {
    return maxHp;
}


auto print(Pokemon& pokemon)-> void {
    std::cout << "Name: " << pokemon.getName() << ", Type: " << pokemon.getType1() << ", Gender: " << pokemon.getGender() << ", Dexterity: " << pokemon.getDexterity() << "%, Health: " << pokemon.getHealth() << ", AttackDmg: " << pokemon.getAttackDmg()<< ", Exp: " << pokemon.getExp() << ", Evolution level: " << pokemon.getEvo()  << '\n';
}
auto evolution(Pokemon& pokemon)-> void{
    int which;
    bool once=false;
    switch(pokemon.getEvo()){
        case 0 : {
            if( pokemon.getExp()>=100){
                pokemon.setEvo(pokemon.getEvo()+1);
                std::cout<<"Select which two attributes you want to increase, 1 for dexterity, 2 for attack dmg, 3 for health, selection of given attribute will increase it by " << 10 * pokemon.getEvo() << " you may chose 1 attribute twice\n";
                for(int i=0; i<2; i++){
                    std::cin>> which;
                    if(which==1)pokemon.setDexterity(pokemon.getDexterity()+ 10 * pokemon.getEvo());
                    if(which==2)pokemon.setAttackDmg(pokemon.getAttackDmg()+ 10 * pokemon.getEvo());
                    if(which==3)pokemon.setHealth(pokemon.getHealth()+ 10 * pokemon.getEvo());
                }
                pokemon.setExp(pokemon.getExp()-100);
            }else std::cout<<"Pokemon has not enough xp\n";
            print(pokemon);
            break;
        }
        case 1: {
            if( pokemon.getExp()>=200){
                pokemon.setEvo(pokemon.getEvo()+1);
                std::cout<<"Select which two attributes you want to increase, 1 for dexterity, 2 for attack dmg, 3 for health, selection of given attribute will increase it by " << 10 * pokemon.getEvo() << " you may chose 1 attribute twice\n";
                for(int i=0; i<2; i++){
                    std::cin>> which;
                    if(which==1)pokemon.setDexterity(pokemon.getDexterity()+ 10 * pokemon.getEvo());
                    if(which==2)pokemon.setAttackDmg(pokemon.getAttackDmg()+ 10 * pokemon.getEvo());
                    if(which==3)pokemon.setHealth(pokemon.getHealth()+ 10 * pokemon.getEvo());
                }
                pokemon.setExp(pokemon.getExp()-200);
            } else std::cout<<"Pokemon has not enough xp\n";
            print(pokemon);
            break;
        }
        case 2:{
            if( pokemon.getExp()>=500){
            pokemon.setEvo(pokemon.getEvo()+1);
            std::cout<<"Select which two attributes you want to increase, 1 for dexterity, 2 for attack dmg, 3 for health, selection of given attribute will increase it by " << 10 * pokemon.getEvo() << " you may chose 1 attribute twice\n";
            for(int i=0; i<2; i++){
                std::cin>> which;
                if(which==1)pokemon.setDexterity(pokemon.getDexterity()+ 10 * pokemon.getEvo());
                if(which==2)pokemon.setAttackDmg(pokemon.getAttackDmg()+ 10 * pokemon.getEvo());
                if(which==3)pokemon.setHealth(pokemon.getHealth()+ 10 * pokemon.getEvo());
            }
            pokemon.setExp(pokemon.getExp()-500);
            }else std::cout<<"Pokemon has not enough xp\n";
            print(pokemon);
            break;
        }
        case 3:{
            std::cout << "Pokemon is fully evolved!\n";
            pokemon.setFinalEvo(true);
            break;
        }
        default: std::cout<<"Pokemon has not enough xp\n";

    }
}
auto operator<<(std::ostream& ostream, PokemonType const t) -> std::ostream&{
    switch(t){
        case PokemonType::Water: ostream << "Water"; break;
        case PokemonType::Earth: ostream << "Earth"; break;
        case PokemonType::Air: ostream << "Air"; break;
        case PokemonType::Fire: ostream << "Fire"; break;
        case PokemonType::Ice: ostream << "Ice"; break;
        case PokemonType::Steel: ostream << "Steel"; break;
    }
}

auto attack(Pokemon &attacking, Pokemon &defending)-> void {
    double x  = multiplier(attacking,defending);
    int random = rand() % 100 ;
    if(random >= defending.getDexterity()){
        defending.setHealth(defending.getHealth()-(attacking.getAttackDmg()*x));
        std::cout << attacking.getName()<< " dealt: " << attacking.getAttackDmg()*x  << " to " << defending.getName()<< " has " << defending.getHealth()  << " hp left\n";
    }
    else std::cout<<"The attack has been dodged!\n";

}
auto multiplier(Pokemon &attacking, Pokemon &defending)->double{
    if(attacking.getType1()==PokemonType::Water){
        switch(defending.getType1()){
            case PokemonType::Water: return 0.5;
            case PokemonType::Earth: return 1.5;
            case PokemonType::Air: return 1;
            case PokemonType::Fire: return 1.5;
            case PokemonType::Ice: return 1;
            case PokemonType::Steel: return 1;
        }
    }
    if(attacking.getType1()==PokemonType::Earth){
        switch(defending.getType1()){
            case PokemonType::Water: return 1;
            case PokemonType::Earth: return 1;
            case PokemonType::Air: return 0.5;
            case PokemonType::Fire: return 1.5;
            case PokemonType::Ice: return 1.5;
            case PokemonType::Steel: return 1.5;
        }
    }
    if(attacking.getType1()==PokemonType::Air){
        switch(defending.getType1()){
            case PokemonType::Water: return 1;
            case PokemonType::Earth: return 0.5;
            case PokemonType::Air: return 1;
            case PokemonType::Fire: return 1;
            case PokemonType::Ice: return 1.5;
            case PokemonType::Steel: return 0.5;
        }
    }
    if(attacking.getType1()==PokemonType::Fire){
        switch(defending.getType1()){
            case PokemonType::Water: return 0.5;
            case PokemonType::Earth: return 0.5;
            case PokemonType::Air: return 1;
            case PokemonType::Fire: return 1;
            case PokemonType::Ice: return 1.5;
            case PokemonType::Steel: return 1.5;
        }
    }
    if(attacking.getType1()==PokemonType::Ice){
        switch(defending.getType1()){
            case PokemonType::Water: return 0.5;
            case PokemonType::Earth: return 1.5;
            case PokemonType::Air: return 1;
            case PokemonType::Fire: return 0.5;
            case PokemonType::Ice: return 0.5;
            case PokemonType::Steel: return 1;
        }
    }
    if(attacking.getType1()==PokemonType::Steel){
        switch(defending.getType1()){
            case PokemonType::Water: return 1.5;
            case PokemonType::Earth: return 1;
            case PokemonType::Air: return 1.5;
            case PokemonType::Fire: return 0.5;
            case PokemonType::Ice: return 1;
            case PokemonType::Steel: return 0.5;
        }
    }
    return 1;
}

auto useSpecial(Pokemon &attacking, Pokemon &defending)->void{
    double x=multiplier(attacking,defending);
    switch(attacking.getType1()){
        case PokemonType::Water:{
            if(attacking.getSpecialPowerUsages()>0){
                std::cout <<"Water pokemon using its special ability healed itself to full hp and strengthened itself with 50 additional attack dmg\n";
                attacking.setHealth(attacking.getHealth() + attacking.getPowerD().healing);
                attacking.setAttackDmg(attacking.getAttackDmg()+50);
                attacking.setSpecialPowerUsages(attacking.getSpecialPowerUsages()-1);
            }else std::cout<<"The pokemon is no longer capable of using his special ability too many uses\n";
            break;
        }
        case PokemonType::Earth:{
            if(attacking.getSpecialPowerUsages()>0){
                std::cout <<"Earth pokemon using its special ability hit his opponent for " << attacking.getPowerO().dmg * x  << " and decreased his strength by 50\n";
                defending.setHealth(defending.getHealth()-attacking.getPowerO().dmg * x);
                defending.setAttackDmg(defending.getAttackDmg()-50);
                attacking.setSpecialPowerUsages(attacking.getSpecialPowerUsages()-1);
            }else std::cout<<"The pokemon is no longer capable of using his special ability too many uses\n";
            break;
        }
        case PokemonType::Air:{
            if(attacking.getSpecialPowerUsages()>0){
                std::cout<<"Air pokemon increased its dexterity by " << attacking.getPowerD().healing << "\n";
                attacking.setDexterity(attacking.getDexterity()+attacking.getPowerD().healing);
                attacking.setSpecialPowerUsages(attacking.getSpecialPowerUsages()-1);
            }else std::cout<<"The pokemon is no longer capable of using his special ability too many uses\n";
            break;
        }
        case PokemonType::Fire:{
            if(attacking.getSpecialPowerUsages()>0){
                std::cout<<"Fire pokemon dealt " << attacking.getPowerO().dmg * x << " by using his special ability\n";
                defending.setHealth(defending.getHealth()-attacking.getPowerO().dmg * x);
                attacking.setSpecialPowerUsages(attacking.getSpecialPowerUsages()-1);
            }else std::cout<<"The pokemon is no longer capable of using his special ability too many uses\n";
            break;
        }
        case PokemonType::Ice:{
            if(attacking.getSpecialPowerUsages()>0){
                std::cout<<"Ice pokemon decreased his opponents dexterity \n";
                defending.setDexterity(defending.getDexterity()-attacking.getPowerO().dmg * x);
                attacking.setSpecialPowerUsages(attacking.getSpecialPowerUsages()-1);
            }else std::cout<<"The pokemon is no longer capable of using his special ability too many uses\n";
            break;
        }
        case PokemonType::Steel:{
            if(attacking.getSpecialPowerUsages()>0){
                std::cout<<"Steel pokemon at the cost of dexterity -50 strengthened himself by 100 and increased his health by " << attacking.getPowerD().healing << "\n";
                attacking.setDexterity(attacking.getDexterity()-50);
                attacking.setHealth(attacking.getHealth()+attacking.getPowerD().healing);
                attacking.setAttackDmg(attacking.getAttackDmg()+100);
                attacking.setSpecialPowerUsages(attacking.getSpecialPowerUsages()-1);
            }else std::cout<<"The pokemon is no longer capable of using his special ability too many uses\n";
            break;
        }
    }
}
auto printVec(std::vector<Pokemon> &pokemons)-> void{
    int x=0;
    for(Pokemon p : pokemons){
        std::cout<< x++ << " ";
        print(p);
    }
}


auto choose(std::vector<Pokemon> &pokemons)->std::vector<Pokemon>{
    std::vector<Pokemon> team;
    std::cout<<"Choose your 6 pokemons out of 15 presented!\n";
    printVec(pokemons);

    std::cout<<"Input the positions of the pokemons u want to take in\n";
    for(int i=0; i<6; i++){
        int position;
        std::cin>>position;
        team.push_back(pokemons.at(position));
    }
    return team;
}
auto chooseEnemies(std::vector<Pokemon> &pokemons,int difficulty)->std::vector<Pokemon>{
    std::vector<Pokemon> enemies;
    for(int i=0; i<4*difficulty; i++){
        int random = rand() % 15;
        enemies.push_back(pokemons.at(random));
    }
    return enemies;
}
auto changePokemon(std::vector<Pokemon> &pokemons)->void{
    int position;
    std::cout<<"Input a position of pokemon which u want to change to ";
    std::cin>>position;
    Pokemon tmp = pokemons.at(0);
    pokemons.at(0)=pokemons.at(position);
    pokemons.at(position)=tmp;
    printVec(pokemons);
}
auto shortcut()->void{
    std::cout<< "Follow the instructions showed in the console, u have to input numbers to make actions in the game\n";
}




