import React from 'react';

const Head = (props) => {
  React.useEffect(() => {
    document.title = 'CWI Engaja | ' + props.title
  }, [props]);
  return <></>;
};

export default Head;
