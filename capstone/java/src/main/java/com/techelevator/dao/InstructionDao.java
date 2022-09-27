package com.techelevator.dao;

import com.techelevator.model.Instruction;

public interface InstructionDao {

    Instruction getInstructionByRecipeId(int recipeID);

    Instruction updateInstruction(Instruction instruction);

    Instruction createInstruction(Instruction instruction);
}
