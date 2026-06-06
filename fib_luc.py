def fib_luc(n, num_elements, seq_type):
    if n < 2:
        raise ValueError("n must be at least 2")
    if num_elements < 1:
        return []
    if seq_type not in ["f", "l"]:
        raise ValueError("seq_type must be 'f' or 'l'")
    
    # Base cases for initials
    if n == 2:
        if seq_type == "f":
            seq = [1, 1]
        else:  # "l"
            seq = [2, 1]
    else:
        # Recursively get first n terms from (n-1) sequence
        prev_seq = fib_luc(n-1, n, seq_type)
        seq = prev_seq[:]
    
    # Now extend the sequence to num_elements if needed
    while len(seq) < num_elements:
        # Sum the last n terms
        next_val = sum(seq[-n:])
        seq.append(next_val)
    
    return seq[:num_elements]
