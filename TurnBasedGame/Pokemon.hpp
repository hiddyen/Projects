#pragma once
#include <string>
#include <iostream>
#include "SpecialPower.hpp"
#include <vector>

enum class PokemonType{Water, Earth, Air , Fire, Ice , Steel};
/****************************************************************************
 * enum class for types of pokemons
 *****************************************************************************/



class Pokemon {

    PokemonType type;
    SpecialOffensivePower powerO;
    SpecialDefensivePower powerD;
    double weight, height;
    std::string gender;
    int specialPowerUsages;
    int evo;
    bool finalEvo;
    int xpWorth;
    std::string name;
    int attackDmg;
    int dexterity;
    int health;
    int exp;
    int maxHp;
public :
    Pokemon(std::string name1, PokemonType type1,SpecialDefensivePower powerD1,int specialPowerUsages1, std::string gender1, int dexterity1, double health1, double attackDmg1, int exp1, int evo1, bool finalEvo1, int xpWorth1);
    Pokemon(std::string name1, PokemonType type1,SpecialOffensivePower powerO1,int specialPowerUsages1, std::string gender1, int dexterity1, double health1, double attackDmg1, int exp1, int evo1, bool finalEvo1, int xpWorth1);
    Pokemon();
            /****************************************************************************
             * Constructors for pokemon class
             *****************************************************************************/
    PokemonType getType1() const;

    const SpecialOffensivePower &getPowerO() const;

    const SpecialDefensivePower &getPowerD() const;

    double getWeight() const;

    double getHeight() const;

    const std::string &getGender() const;

    int getSpecialPowerUsages() const;

    int getEvo() const;

    bool isFinalEvo() const;

    int getXpWorth() const;

    const std::string &getName() const;

    int getAttackDmg() const;

    int getDexterity() const;

    int getHealth() const;

    int getExp() const;

    int getMaxHp() const;

    void setType(PokemonType type);

    void setPowerO(const SpecialOffensivePower &powerO);

    void setPowerD(const SpecialDefensivePower &powerD);

    void setWeight(double weight);

    void setHeight(double height);

    void setGender(const std::string &gender);

    void setSpecialPowerUsages(int specialPowerUsages);

    void setEvo(int evo);

    void setFinalEvo(bool finalEvo);

    void setXpWorth(int xpWorth);

    void setName(const std::string &name);

    void setAttackDmg(int attackDmg);

    void setDexterity(int dexterity);

    void setHealth(int health);

    void setExp(int exp);

    void setMaxHp(int maxHp);
};


auto operator<<(std::ostream& ostream, PokemonType const t) -> std::ostream&;
/****************************************************************************
 * Operator enabling printing out enum types
 *****************************************************************************/
auto print(Pokemon&)-> void;
/****************************************************************************
 * function responsible for printing out all pokemon variables
 *****************************************************************************/
auto evolution(Pokemon& pokemon)-> void;
/****************************************************************************
 * function which evolves the pokemons and increases their stats
 *****************************************************************************/
auto attack(Pokemon&, Pokemon&)-> void;
/****************************************************************************
 * function which simulates one pokemon taking dmg from another it updates health of the victim
 *****************************************************************************/
auto multiplier(Pokemon &attacking, Pokemon &defending)->double;
/****************************************************************************
 * functions which returns pokemon attack multiplier based on pokemons types
 *****************************************************************************/
auto useSpecial(Pokemon&, Pokemon&)->void;
/****************************************************************************
 * function implementing every types special ability
 *****************************************************************************/
auto choose(std::vector<Pokemon>&)->std::vector<Pokemon>;
/****************************************************************************
 * function responsible for letting the player choose his pokemons from given vector
 *****************************************************************************/
auto printVec(std::vector<Pokemon>&)-> void;
/****************************************************************************
 * function printing vector of creatures and all of their attribute using previous function print
 *****************************************************************************/
auto changePokemon(std::vector<Pokemon>&)->void;
/****************************************************************************
 * function which lets the player change the pokemon that its currently in use
 *****************************************************************************/
auto chooseEnemies(std::vector<Pokemon>&,int)->std::vector<Pokemon>;
/****************************************************************************
 * function responsible for choosing random enemies from vector, and the number of enemies is dependant on the difficulty of the game which the player chooses
 *****************************************************************************/
auto shortcut()->void;
/****************************************************************************
 * function printing help command
 *****************************************************************************/