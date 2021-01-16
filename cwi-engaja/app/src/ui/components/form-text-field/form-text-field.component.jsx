import React, { useEffect, useRef } from 'react';
import { Box, TextField } from '@material-ui/core';
import { useField } from '@unform/core'
import { withStyles } from '@material-ui/core/styles';

const TextFieldCustom = withStyles({
  root: {
    '& label.Mui-focused': {
      color: '#333',
    },
    '& .MuiInput-underline:after': {
      borderBottomColor: "#FFB041"
    },
    '& .MuiOutlinedInput-root': {
      '& fieldset': {
        borderColor: "#333",
        borderWidth: "2px",
      },
      '&:hover fieldset': {
        borderColor: "#FFB041",
      },
      '&.Mui-focused fieldset': {
        borderColor: "#FFB041",
      },
    },
  },
})(TextField);

export function FormTextField({ name, marginBottom, width, ...rest }) {

  const inputRef = useRef(null)
  const { fieldName, defaultValue, registerField } = useField(name);

  useEffect(() => {
    registerField({
      name: fieldName,
      ref: inputRef.current,
      path: 'value',
    });
  }, [fieldName, registerField]);

  return (
    <>
      <Box mb={marginBottom} width={width}>
        <TextFieldCustom
          inputRef={inputRef}
          defaultValue={defaultValue}
          variant='outlined'
          {...rest}
          fullWidth
        />
      </Box>
    </>
  )
}
