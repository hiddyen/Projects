#pragma once
#include <string>


/****************************************************************************
 * Constructors with arguments and without
 * Destructors for the class SpecialPower Offensive and Defensive
 *****************************************************************************/

class SpecialOffensivePower{
public:
    std::string name;
    int duration;
    int dmg;
    SpecialOffensivePower(std::string name1, int duration1,int dmg1);
    SpecialOffensivePower();

    virtual ~SpecialOffensivePower();
};
class SpecialDefensivePower{
public:
    std::string name;
    int duration;
    int healing;
    SpecialDefensivePower(std::string name1, int duration1, int healing1);
    SpecialDefensivePower();

    virtual ~SpecialDefensivePower();
};



