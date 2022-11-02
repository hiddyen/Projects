#include "SpecialPower.hpp"

SpecialOffensivePower::SpecialOffensivePower(std::string name1,int duration1,int dmg1){
    name=name1;
    duration=duration1;
    dmg=dmg1;
}
SpecialOffensivePower::~SpecialOffensivePower() {}

SpecialOffensivePower::SpecialOffensivePower() {}

SpecialDefensivePower::SpecialDefensivePower(std::string name1,int duration1, int healing1){
    name=name1;
    duration=duration1;
    healing=healing1;
}
SpecialDefensivePower::~SpecialDefensivePower() {}

SpecialDefensivePower::SpecialDefensivePower() {}


