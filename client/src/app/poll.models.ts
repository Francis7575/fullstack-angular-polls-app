export interface OptionVote {
  optionText: string
  voteCount: number
}

export interface Poll {
  question: string
  options: OptionVote[]
}
